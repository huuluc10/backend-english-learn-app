package com.huuluc.englearn.model.response;

import com.huuluc.englearn.model.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HistoryLearnTopicResponse extends Topic {
    private float successRate;

    public HistoryLearnTopicResponse(Topic topic, float successRate) {
        super(topic.getTopicId(), topic.getTopicName());
        this.successRate = successRate;
    }
}
