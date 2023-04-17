package com.gpt.example.practice.domain.book.exception;

import com.gpt.example.practice.global.exception.ErrorCode;
import com.gpt.example.practice.global.exception.ServiceException;

public class BookNotFoundException extends ServiceException {
    private static final ErrorCode ERROR_CODE = ErrorCode.BOOK_NOT_FOUND;
    private static final String MESSAGE_KEY = "exception.book.notfound";

    public BookNotFoundException(Long id) {
        super(ERROR_CODE, MESSAGE_KEY, new Object[] { id });
    }
}
