# freshman

### Project Structure
```.
├── Dockerfile
├── LICENSE
├── README.md
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    └── main
        ├── java
        │   └── kr
        │       └── hs
        │           └── entrydsm
        │               └── freshman
        │                   ├── EntryFreshmanApplication.java
        │                   ├── domain
        │                   │   ├── image
        │                   │   │   ├── exception
        │                   │   │   │   ├── ImageNotFoundException.java
        │                   │   │   │   └── InvalidImageExtensionFormatException.java
        │                   │   │   ├── service
        │                   │   │   │   └── ImageService.java
        │                   │   │   └── web
        │                   │   │       ├── ImageController.java
        │                   │   │       └── dto
        │                   │   │           └── response
        │                   │   │               └── ImageResponse.java
        │                   │   ├── post
        │                   │   │   ├── domain
        │                   │   │   │   ├── Post.java
        │                   │   │   │   └── PostRepository.java
        │                   │   │   ├── exception
        │                   │   │   │   ├── NoPermissionToDeletePostException.java
        │                   │   │   │   ├── NoPermissionToModifyPostException.java
        │                   │   │   │   └── PostNotFoundException.java
        │                   │   │   ├── service
        │                   │   │   │   ├── CreatePostService.java
        │                   │   │   │   ├── DeletePostService.java
        │                   │   │   │   ├── PostDetailsService.java
        │                   │   │   │   ├── PostListService.java
        │                   │   │   │   └── UpdatePostService.java
        │                   │   │   └── web
        │                   │   │       ├── PostController.java
        │                   │   │       └── dto
        │                   │   │           ├── request
        │                   │   │           │   ├── CreatePostRequest.java
        │                   │   │           │   └── UpdatePostRequest.java
        │                   │   │           └── response
        │                   │   │               ├── PostDetailsResponse.java
        │                   │   │               ├── PostElement.java
        │                   │   │               └── PostListResponse.java
        │                   │   └── user
        │                   │       ├── domain
        │                   │       │   ├── User.java
        │                   │       │   └── UserRepository.java
        │                   │       ├── exception
        │                   │       │   ├── PasswordMisMatchException.java
        │                   │       │   ├── UserExistsException.java
        │                   │       │   └── UserNotFoundException.java
        │                   │       ├── service
        │                   │       │   ├── MyPageService.java
        │                   │       │   ├── SignInService.java
        │                   │       │   ├── SignUpService.java
        │                   │       │   └── UpdateUserInfoService.java
        │                   │       └── web
        │                   │           ├── UserController.java
        │                   │           └── dto
        │                   │               ├── request
        │                   │               │   ├── SignInRequest.java
        │                   │               │   ├── SignUpRequest.java
        │                   │               │   └── UpdateUserInfoRequest.java
        │                   │               └── response
        │                   │                   ├── MyPageElement.java
        │                   │                   ├── MyPageResponse.java
        │                   │                   └── TokenResponse.java
        │                   ├── global
        │                   │   ├── cors
        │                   │   │   └── WebMvcConfig.java
        │                   │   ├── error
        │                   │   │   ├── CustomException.java
        │                   │   │   ├── ErrorCode.java
        │                   │   │   ├── ErrorResponse.java
        │                   │   │   ├── ExceptionFilter.java
        │                   │   │   └── ExceptionHandler.java
        │                   │   ├── facade
        │                   │   │   └── CurrentUserFacade.java
        │                   │   ├── property
        │                   │   │   └── EnableConfigurationPropertiesConfig.java
        │                   │   └── security
        │                   │       ├── FilterConfig.java
        │                   │       ├── SecurityConfig.java
        │                   │       ├── auth
        │                   │       │   ├── AuthDetails.java
        │                   │       │   └── AuthDetailsService.java
        │                   │       ├── exception
        │                   │       │   ├── ExpiredJwtException.java
        │                   │       │   └── InvalidJwtException.java
        │                   │       └── jwt
        │                   │           ├── JwtProperty.java
        │                   │           ├── JwtTokenFilter.java
        │                   │           └── JwtTokenProvider.java
        │                   └── infrastructure
        │                       └── s3
        │                           ├── ImageFacade.java
        │                           └── S3Config.java
        └── resources
            └── application.yml

44 directories, 67 files
```
