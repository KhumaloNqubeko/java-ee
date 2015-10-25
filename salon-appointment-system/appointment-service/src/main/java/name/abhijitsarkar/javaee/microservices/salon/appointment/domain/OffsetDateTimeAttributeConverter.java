package name.abhijitsarkar.javaee.microservices.salon.appointment.domain;

import java.time.OffsetDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import name.abhijitsarkar.javaee.microservices.salon.domain.OffsetDateTimeConverter;

@Converter
public class OffsetDateTimeAttributeConverter implements AttributeConverter<OffsetDateTime, String> {
	private final OffsetDateTimeConverter converter = new OffsetDateTimeConverter();

	@Override
	public String convertToDatabaseColumn(OffsetDateTime dateTime) {
		return converter.format(dateTime);
	}

	@Override
	public OffsetDateTime convertToEntityAttribute(String dateTime) {
		return converter.parse(dateTime);
	}
}
