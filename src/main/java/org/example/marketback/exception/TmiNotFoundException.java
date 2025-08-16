package org.example.marketback.exception;

public class TmiNotFoundException extends RuntimeException {
    public TmiNotFoundException() {
        super("해당 TMI를 찾을 수 없습니다.");
    }
}