package az.developia.libraryproject.model;

import java.util.List;

import lombok.Data;

@Data
public class DataWrapper {

	private List<ErrorResponse> validation;
}
