package telran.fin_tech.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Embeddable
public class HistoryDataId implements Serializable {
	private static final long serialVersionUID = 6057213438298187210L;

		@Column(name = "date")
        private LocalDate date;

        @Column(name = "ticker")
        private String ticker;

}
