package web.majiang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.majiang.DTO.QuestionDTO;
import web.majiang.dao.questionDAO;
import web.majiang.dao.userDAO;
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

    public QuestionDTOPageInfo<questionDAO> QuestionPagingQuery(int pageNum,int pageSize){
        List<QuestionDTO> QuestionDTOList = new ArrayList<>();
        //1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
        PageHelper.startPage(pageNum,pageSize);
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        //先查出question对象列表
        List<questionDAO> questionList = questionDAOMapper.selectAll();
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
}
