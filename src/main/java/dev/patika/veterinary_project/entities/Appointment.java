package dev.patika.veterinary_project.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;

    //Randevular sisteme tarih ve saat içerecek şekilde kaydedilmelidir. Bunun için LocalDateTime kullanılmalıdır.
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;

    @ManyToOne  (fetch = FetchType.EAGER)
    @JoinColumn(name = "appointment_animal_id", referencedColumnName = "animal_id")
    private Animal animal;

    @ManyToOne  (fetch = FetchType.EAGER)
    @JoinColumn(name = "appointment_doctor_id", referencedColumnName = "doctor_id")
    private Doctor doctor;

    @OneToOne(mappedBy = "appointment", fetch = FetchType.EAGER)
    @JsonIgnore
    private Report report;
}
