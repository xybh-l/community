package online.lanwang.community.service;

import online.lanwang.community.dto.QuestionDTO;
import online.lanwang.community.mapper.QuestionMapper;
import online.lanwang.community.mapper.UserMapper;
import online.lanwang.community.model.Question;
import online.lanwang.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xybh on 2019/7/21
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<QuestionDTO>questionDTOList = new ArrayList<>();
        List<Question> questions = questionMapper.list();
        for (Question question:
                questions
             ) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
