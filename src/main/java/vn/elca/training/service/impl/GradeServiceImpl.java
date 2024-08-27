package vn.elca.training.service.impl;

import org.springframework.stereotype.Service;
import vn.elca.training.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService {
    @Override
    public char determineGrade(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
