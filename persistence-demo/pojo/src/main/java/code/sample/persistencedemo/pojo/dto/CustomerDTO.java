package code.sample.persistencedemo.pojo.dto;

import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomerDTO {
    private Long id;

    @Size(min = 1, max = 255)
    private String name;
    //    private Set<TransactionDTO> transactionDTOS;
}
