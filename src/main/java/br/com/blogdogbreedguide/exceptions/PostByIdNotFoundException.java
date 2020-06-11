package br.com.blogdogbreedguide.exceptions;

public class PostByIdNotFoundException extends RuntimeException {

    public PostByIdNotFoundException(String message) {
        super(message);
    }

}
