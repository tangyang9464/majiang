package web.majiang.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import web.majiang.DTO.CommentShowDTO;
import web.majiang.DTO.QuestionDTO;
import web.majiang.dao.commentDAO;
import web.majiang.dao.questionDAO;
import web.majiang.dao.userDAO;
import web.majiang.mapper.commentDAOMapper;
import web.majiang.mapper.questionDAOMapper;
import web.majiang.mapper.userDAOMapper;
import web.majiang.util.QuestionDTOPageInfo;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    questionDAOMapper questionDAOMapper;
    @Autowired
    userDAOMapper userDAOMapper;

    public QuestionDTOPageInfo<questionDAO> QuestionPagingQuery(int pageNum,int pageSize,Example example){
        List<QuestionDTO> QuestionDTOList = new ArrayList<>();
        //1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
        PageHelper.startPage(pageNum,pageSize);
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        //先查出question对象列表
        List<questionDAO> questionList;
        if(example!=null){
            questionList = questionDAOMapper.selectByExample(example);
        }
        else {
            questionList = questionDAOMapper.selectAll();
        }
        for (questionDAO Q: questionList) {
            QuestionDTO QT = new QuestionDTO();
            //复制数据到DTO
            BeanUtils.copyProperties(Q, QT);
            //查询user对象
            userDAO user = userDAOMapper.selectByPrimaryKey(Q.getCreator());
//            放入DTO
            QT.setUser(user);
//            添加到列表中
            QuestionDTOList.add(QT);
        }
        QuestionDTOPageInfo<questionDAO> questionDTOPageInfo = new QuestionDTOPageInfo<questionDAO>(QuestionDTOList,questionList, pageSize);
        return questionDTOPageInfo;
    }

    public QuestionDTO selectByPrimaryKey(Object obj){
        questionDAO questionDAO = questionDAOMapper.selectByPrimaryKey(obj);
        QuestionDTO QT = new QuestionDTO();
        //复制数据到DTO
        BeanUtils.copyProperties(questionDAO, QT);
        //查询user对象
        userDAO user = userDAOMapper.selectByPrimaryKey(questionDAO.getCreator());
//      放入DTO
        QT.setUser(user);
        return QT;
    }

    public void updateByExampleSelective(String property,Object value, questionDAO questionDAO){
        Example questionExample = new Example(questionDAO.class);
        questionExample.createCriteria().andEqualTo(property,value);
        questionDAOMapper.updateByExampleSelective(questionDAO,questionExample);
    }
}
