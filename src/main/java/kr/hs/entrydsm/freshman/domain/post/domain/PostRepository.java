package kr.hs.entrydsm.freshman.domain.post.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAll();

    List<Post> findAllByUserId(Long userId);
}
