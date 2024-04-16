package com.woojin.boardback.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.woojin.boardback.repository.resultSet.GetCommentListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentListItem {
    private String nickname;
    private String profileImage;
    private String writeDatetime;
    private String content;

    public CommentListItem(GetCommentListResultSet resultset) {
        this.nickname = resultset.getNickname();
        this.profileImage = resultset.getProfileImage();
        this.writeDatetime = resultset.getWriteDatetime();
        this.content = resultset.getContent();
          
        }
        
        public static List<CommentListItem> copyList(List<GetCommentListResultSet> resultSets) {
        List<CommentListItem> list = new ArrayList<>();
        for (GetCommentListResultSet resultSet: resultSets) {
        CommentListItem commentListItem = new CommentListItem(resultSet);
        list.add(commentListItem);
        }
        return list;
    }

}
