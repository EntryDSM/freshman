package kr.hs.entrydsm.freshman.domain.post.web;

import kr.hs.entrydsm.freshman.domain.post.service.CreatePostService;
import kr.hs.entrydsm.freshman.domain.post.service.DeletePostService;
import kr.hs.entrydsm.freshman.domain.post.service.PostDetailsService;
import kr.hs.entrydsm.freshman.domain.post.service.PostListService;
import kr.hs.entrydsm.freshman.domain.post.service.UpdatePostService;
import kr.hs.entrydsm.freshman.domain.post.web.dto.request.CreatePostRequest;
import kr.hs.entrydsm.freshman.domain.post.web.dto.request.UpdatePostRequest;
import kr.hs.entrydsm.freshman.domain.post.web.dto.response.PostDetailsResponse;
import kr.hs.entrydsm.freshman.domain.post.web.dto.response.PostListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@RequestMapping("/posts")
@RestController
public class PostController {

    private final CreatePostService createPostService;
    private final UpdatePostService updatePostService;
    private final PostListService postListService;
    private final PostDetailsService postDetailsService;
    private final DeletePostService deletePostService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createPost(@RequestBody @Valid CreatePostRequest request) {
        createPostService.execute(request);
    }

    @PatchMapping("/{post-id}")
    public void updatePost(@PathVariable("post-id") @NotNull Long postId,
                           @RequestBody @Valid UpdatePostRequest request) {
        updatePostService.execute(postId, request);
    }

    @GetMapping("/lists")
    public PostListResponse getPostList() {
        return postListService.execute();
    }

    @GetMapping("/{post-id}")
    public PostDetailsResponse getPostDetails(@PathVariable("post-id") @NotNull Long postId) {
        return postDetailsService.execute(postId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{post-id}")
    public void deletePost(@PathVariable("post-id") @NotNull Long postId) {
        deletePostService.execute(postId);
    }
}
