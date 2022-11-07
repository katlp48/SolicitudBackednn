package pe.edu.estubeca.estubeca.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.estubeca.estubeca.entities.Post;

import pe.edu.estubeca.estubeca.exception.ResourceNotFoundException;
import pe.edu.estubeca.estubeca.repository.PostRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostRepository postRepository;
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> posts=postRepository.findAll();
        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
    }
    @GetMapping("/posts/reverse")
    public ResponseEntity<List<Post>> getPostsDescendente(){
        List<Post> posts=postRepository.postsDescendente();
        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
    }
    //GET=>http:localthost:8080/api/posts/1
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id){
        Post post= postRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found post with id="+id));


        return new ResponseEntity<Post>(post,HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost( @RequestBody Post post){
        Post newPost=
                postRepository.save(
                        new Post(
                                post.getSlug(),
                                post.getTitle(),
                                post.getDescription(),
                                post.getBody(),
                                post.getTagList(),
                                post.getCreatedAt(),
                                post.getUpdatedAt(),
                                post.getFavorite(),
                                post.getFavoritesCount(),
                                post.getAuthor(),
                                post.isPublished())
                );
        return new ResponseEntity<Post>(newPost,HttpStatus.CREATED);
    }

    //PUT=>http:localthost:8080/api/posts/1
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(
            @PathVariable("id") Long id,
            @RequestBody Post post){
        Post postUpdate= postRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found post with id="+id));

        postUpdate.setTitle(post.getTitle());
        postUpdate.setDescription(post.getDescription());
        postUpdate.setBody(post.getBody());
        postUpdate.setPublished(post.isPublished());
        postUpdate.setTagList(post.getTagList());
        postUpdate.setUpdatedAt(post.getUpdatedAt());
        postUpdate.setFavoritesCount(post.getFavoritesCount());

        return new ResponseEntity<Post>(postRepository.save(postUpdate),
                HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") Long id){
        postRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/post/published")
    public  ResponseEntity<List<Post>> findPostByPublished(){
        List<Post> posts=postRepository.findByPublishedSQL(true);
        if(posts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

}
