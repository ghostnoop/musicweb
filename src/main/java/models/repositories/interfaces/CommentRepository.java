package models.repositories.interfaces;

import models.entities.Comment;

import java.util.List;

public interface CommentRepository extends OrmRepository<Comment> {
    List<Comment> getAllBySongId(int _id);
}
