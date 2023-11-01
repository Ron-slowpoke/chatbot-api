package cn.zzh.chatbot.api.domain.zsxq;

import cn.zzh.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

//API接口
public interface IZsxqApi {
//    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;
//    boolean answer(String topicId,String groupId,String cookie,String text,boolean silenced) throws IOException;
UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;

    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;
}
