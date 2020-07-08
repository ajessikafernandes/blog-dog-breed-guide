package br.com.blogdogbreedguide.service;

import br.com.blogdogbreedguide.entity.Post;
import br.com.blogdogbreedguide.exceptions.IdCannotBeNullException;
import br.com.blogdogbreedguide.exceptions.PostByIdNotFoundException;
import br.com.blogdogbreedguide.exceptions.PostCannotBeNullException;
import br.com.blogdogbreedguide.exceptions.PostNotFoundException;
import br.com.blogdogbreedguide.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public boolean createNewPost(Post post) {
        validatePostNotNull(post);
        repository.save(post);
        return true;
    }

    public List<Post> findAllPostList(){
        List<Post> posts = repository.findAll();
//        Collections.sort(posts, Collections.reverseOrder());
        return posts;
    }

    public Post findPostById(Long id) {
        validatePostIdNotNull(id);
        Optional<Post> postIn = repository.findById(id);
        if (!postIn.isPresent()) {
            throw new PostByIdNotFoundException("Informed post id not found");
        }
        return postIn.get();
    }

    private Boolean validatePostIdNotNull(Long id) {
        if (id != null) {
            return true;
        }
        throw new IdCannotBeNullException("Post id not found.");
    }

    private Boolean validatePostNotNull(Post post) {
        if (Objects.isNull(post)) {
            throw new PostCannotBeNullException("Post cannot be null");
        }
        return true;
    }

}
