package com.gmail.merikbest.ecommerce.exception;

import lombok.Getter;

@Getter
public class CaptchaException extends RuntimeException {
    private final String captchaError;

    public CaptchaException(String captchaError){this.captchaError = captchaError;}
}
