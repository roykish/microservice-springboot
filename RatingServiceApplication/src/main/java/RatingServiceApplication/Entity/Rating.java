package RatingServiceApplication.Entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rating_id")
    private int ratingId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "hotel_id")
    private String hotelId;
    @Column(name = "rating")
    private String rating;
    @Column(name = "remark")
    private String remark;

}
