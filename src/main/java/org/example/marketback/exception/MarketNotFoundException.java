package org.example.marketback.exception;

public class MarketNotFoundException extends RuntimeException {
    public MarketNotFoundException() {
        super("해당 상점을 찾을 수 없습니다.");
    }
}

