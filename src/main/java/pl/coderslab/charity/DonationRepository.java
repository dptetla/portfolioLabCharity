package pl.coderslab.charity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository <Donation, Long> {

    }


