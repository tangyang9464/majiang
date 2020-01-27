package web.majiang.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.majiang.DTO.QuestionDTO;
import web.majiang.dao.questionDAO;
import web.majiang.dao.userDAO;
import web.majiang.mapper.questionDAOMapper;
import web.majiang.mapper.userDAOMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    questionDAOMapper questionDAOMapper;
    @Autowired
    userDAOMapper userDAOMapper;

    public List<QuestionDTO> list(){
        List<QuestionDTO> QuestionDTOList = new ArrayList<>();
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
        return QuestionDTOList;
    }
}
