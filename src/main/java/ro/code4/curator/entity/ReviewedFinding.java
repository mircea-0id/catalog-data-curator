package ro.code4.curator.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class ReviewedFinding {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	private ReviewedText reviewedInputId;

	@OneToOne
	private ReviewedFinding parentField;

	private String fieldName;
	private int startPos;
	private int endPos;
	@Lob
	private String parsedValue;
	private double votes;
	private String parserId;

    @Override
    public String toString() {
        // avoid parent circular ref
        return "ReviewedInputField{" +
                "id=" + id +
                ", fieldName='" + fieldName + '\'' +
                ", startPos=" + startPos +
                ", endPos=" + endPos +
                ", parsedValue='" + parsedValue + '\'' +
                ", votes=" + votes +
                ", parserId='" + parserId + '\'' +
                '}';
    }
}
