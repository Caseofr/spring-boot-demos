package code.sample.persistencedemo.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TransactionDTO {
    private Long id;
    private Double amount;
}
