package az.developia.testapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.testapp.model.ErrorReport;
import az.developia.testapp.model.TestAddModel;

public interface ErrorReportRepository extends JpaRepository<ErrorReport, Integer> {

	List<ErrorReport> findByTest(TestAddModel test);

}
