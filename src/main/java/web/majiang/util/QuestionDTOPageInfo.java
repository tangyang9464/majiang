package web.majiang.util;

import com.github.pagehelper.PageInfo;
import web.majiang.DTO.QuestionDTO;

import java.util.List;

public class QuestionDTOPageInfo<T> extends PageInfo<T> {
    private List<QuestionDTO> QuestionDTOList;

    public QuestionDTOPageInfo(List<QuestionDTO> QL, List<T> questionList, int pageSize) {
        super(questionList,pageSize);
        this.QuestionDTOList = QL;
    }

    public List<QuestionDTO> getQuestionDTOList() {
        return QuestionDTOList;
    }

    public void setQuestionDTOList(List<QuestionDTO> questionDTOList) {
        QuestionDTOList = questionDTOList;
    }

}
