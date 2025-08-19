package org.example.marketback.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.marketback.entity.enums.Category;

@Getter
@NoArgsConstructor
public class TmiCreateRequest {

    @NotNull(message = "마켓 ID는 필수입니다.")
    private Long marketId;

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    private String email;

    @NotNull(message = "카테고리는 필수입니다.")
    private Category category;
}