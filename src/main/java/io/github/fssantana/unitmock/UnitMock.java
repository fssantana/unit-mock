package io.github.fssantana.unitmock;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @since 0.1.0
 * @author fsantana
 *
 * UnitMock class which contains methods with many mock types
 *
 */
public class UnitMock {

	private UnitMock() {}

	private static final String CHARS = "abcdefghijklmnopqrstuvxwyz";
	private static final String CHARS_NUMBERS = "abcdefghijklmnopqrstuvxwyz0123456789";
	private static final String NUMBERS = "0123456789";

    /**
     * Creates a random LocalDate instance
     *
     * @return
     *
     */
	public static LocalDate localDate() {
		return LocalDate.of(
		        random().nextInt(1990, 2051),
                random().nextInt(1, 13),
                random().nextInt(1, 21)
        );
	}

    /**
     * Creates a random LocalTime instance
     *
     * @return
     *
     */
	public static LocalTime localTime() {
		return LocalTime.of(
		        random().nextInt(0, 24),
                random().nextInt(0, 60),
                random().nextInt(0, 60)
        );
	}

    /**
     * Creates a random LocalDateTime instance
     *
     * @return
     *
     */
	public static LocalDateTime localDateTime() {
		return LocalDateTime.of(localDate(), localTime());
	}

    /**
     * Creates a random Date instance
     *
     * @return
     *
     */
	public static Date date() {
		return new Date(
		        random().nextLong(100000000L, 100000000001L)
        );
	}

    /**
     * Creates a random Date instance as string with pattern yyyy-MM-dd
     *
     * @return
     *
     */
	public static String dateAsString() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date());
	}

    /**
     * Creates a random Date and Time instance as String with pattern yyyy-MM-dd hh:MM:ss
     *
     * @return
     *
     */
	public static String dateTimeAsString() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		return format.format(date());
	}

    /**
     * Creates a random Date instance with desired pattern
     *
     * @return
     *
     */
    public static String dateAsString(String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date());
    }

    /**
     * Creates a random Date and Time instance with desired pattern
     *
     * @return
     *
     */
    public static String dateTimeAsString(String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date());
    }

    /**
     * Creates a random BigDecimal instance
     * <br>
     * min - 0.00; max - 10001.00; ROUND_HALF_DOWN; scale 2
     *
     * @return
     *
     */
	public static BigDecimal bigDecimal() {
		BigDecimal bigDecimal = new BigDecimal(
		        random()
                        .nextDouble(0.00, 10001.00)
        );

		bigDecimal = bigDecimal
                .setScale(2, BigDecimal.ROUND_HALF_DOWN);

		return bigDecimal;
	}

    /**
     * Creates a random BigDecimal instance
     *
     * @return
     *
     */
    public static BigDecimal bigDecimal(Double min, Double max, Integer scale, Integer roundMode) {
        BigDecimal bigDecimal = new BigDecimal(
                random()
                        .nextDouble(min, max)
        );

        if(scale != null && roundMode != null){
            bigDecimal = bigDecimal
                    .setScale(scale, roundMode);
        }

        return bigDecimal;
    }

    /**
     * Returns the current {@link ThreadLocalRandom}
     * @return
     *
     */
	public static ThreadLocalRandom random() {
		return ThreadLocalRandom.current();
	}

    /**
     * Creates a random BigDecimal as String
     * <br>
     * min - 0.00; max - 10001.00; ROUND_HALF_DOWN; scale 2
     * @return
     *
     */
	public static String bigDecimalAsString() {
		return bigDecimal().toString();
	}

    /**
     * Creates a random BigDecimal as String
     * @return
     *
     */
    public static String bigDecimalAsString(Double min, Double max, Integer scale, Integer roundMode) {
        return bigDecimal(min, max, scale, roundMode)
                .toString();
    }

    /**
     * Creates a random Integer
     * @return
     *
     */
	public static Integer getInteger() {
		return random()
                .nextInt(999999);
	}

    /**
     * Creates a random Long
     * @return
     *
     */
	public static Long getLong() {
		return random()
                .nextLong();
	}

    /**
     * Creates a random Float
     * @return
     *
     */
	public static Float getFloat() {
		return random()
                .nextFloat();
	}

    /**
     * Creates a random BigInteger
     * @return
     *
     */
	public static BigInteger getBigInteger() {
		return BigInteger.valueOf(getInteger());
	}

    /**
     * Creates a random Boolean
     * @return
     *
     */
	public static Boolean getBoolean() {
		return (random().nextInt(11) >= 5);
	}

    /**
     * Creates a random type 4 UUID
     * @return
     *
     */
	public static String uuid() {
		return UUID
                .randomUUID()
                .toString();
	}

    /**
     * Creates a random String with desired length
     * @return
     *
     */
	private static String getString(Integer amount) {
		if (amount == null || amount == 0) {
			amount = 1;
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < amount; i++) {
			char c = CHARS.charAt(random().nextInt(CHARS.length()));
			stringBuilder.append(c);
		}
		return stringBuilder.toString();
	}

    /**
     * Creates a random String with desired length and using informed chars
     * @return
     *
     */
    private static String getString(Integer amount, String charSequence) {
        if (amount == null || amount == 0) {
            amount = 1;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            char c = charSequence.charAt(random().nextInt(charSequence.length()));
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * Creates a random String with desired length. Only alphabetic
     * @return
     *
     */
	public static String alphabetic(int amount) {
		return getString(amount, CHARS);
	}

    /**
     * Creates a random alphanumeric String with desired length
     * @return
     *
     */
	public static String alphanumeric(int amount) {
		return getString(amount, CHARS_NUMBERS);
	}

    /**
     * Creates a random String with desired length. Only Numeric
     * @return
     *
     */
	public static String getNumeric(int amount) {
		return getString(amount, NUMBERS);
	}

    /**
     * Creates a random email with desired length. This email will end with .com
     * @return
     *
     */
	public static String email(int amount) {
		return alphabetic(amount) + "@"+alphabetic(5)+".com";
	}

    /**
     * Creates a random email with desired length and random domain length. This email will end with .com
     * @return
     *
     */
    public static String email(int amount, int domainAmount) {
        return alphabetic(amount) + "@"+alphabetic(domainAmount)+".com";
    }

    /**
     * Creates a random email with desired length and domain
     * @return
     *
     */
    public static String email(int amount, String domain) {
        return alphabetic(amount) + domain;
    }

    /**
     * Creates an instance of informed class with random filled attributes <br>
     * Use level to build recursively deeper classes attributes
     *
     * @return
     *
     */
	public static <T> T buildFor(Class<T> clazz, int level) throws RuntimeException {
        T instance = null;
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        for (Field field : clazz.getDeclaredFields()) {
			if (!Modifier.isStatic(field.getModifiers())) {
				try {
					field.setAccessible(true);
					Object value = getValue(field, level);
					field.set(instance, value);
				} catch (Exception e) {
                    try {
                        field.set(instance, null);
                    } catch (IllegalAccessException e1) {
                        throw new RuntimeException(e);
                    }
                }
			}
		}

		if (clazz.getSuperclass() != null) {
			for (Field field : clazz.getSuperclass().getDeclaredFields()) {
				if (!Modifier.isStatic(field.getModifiers())) {
					try {
						field.setAccessible(true);
						Object value = getValue(field, level);
						field.set(instance, value);
					} catch (Exception e) {
                        try {
                            field.set(instance, null);
                        } catch (IllegalAccessException e1) {
                            throw new RuntimeException(e);
                        }
                    }
				}
			}
		}

		return instance;
	}

	private static Object getValue(Field field, int level) {
		Class<?> type = field.getType();
		return getValue(type, field, level);
	}

    /**
     * Build random value of informed type and field
     *
     * @return
     *
     */
	private static Object getValue(Class<?> type, Field field, int level) {
		if (type.isEnum()) {
			Object[] enumValues = type.getEnumConstants();
			return enumValues[random().nextInt(enumValues.length)];
		} else if (type.equals(Integer.TYPE) || type.equals(Integer.class)) {
			return getInteger();
		} else if (type.equals(Boolean.TYPE) || type.equals(Boolean.class)) {
			return getBoolean();
		} else if (type.equals(Long.TYPE) || type.equals(Long.class)) {
			return getLong();
		} else if (type.equals(Double.TYPE) || type.equals(Double.class)) {
			return getFloat().doubleValue();
		} else if (type.equals(Float.TYPE) || type.equals(Float.class)) {
			return getFloat();
		} else if (type.equals(String.class)) {
			return alphabetic(5);
		} else if (type.equals(BigInteger.class)) {
			return getBigInteger();
		} else if (type.equals(LocalDateTime.class)) {
			return localDateTime();
		} else if (type.equals(LocalDate.class)) {
			return localDate();
		} else if (type.equals(LocalTime.class)) {
			return localTime();
		} else if (type.equals(Date.class)) {
			return date();
		} else if (type.equals(BigDecimal.class)) {
			return bigDecimal();
		} else if (type.equals(List.class)) {
			List<Object> values = new ArrayList<>();
			Class<?> listClassType = (Class<?>) ((ParameterizedType) field.getGenericType())
					.getActualTypeArguments()[0];

			for (int i = 0; i < random().nextInt(1000); i++) {
				Object value = getValue(listClassType, field, level - 1);
				if (value == null) {
					break;
				}
				values.add(value);
			}

			return values;
		} else if (type.equals(Set.class)) {
			Set<Object> values = new HashSet<>();
			Class<?> listClassType = (Class<?>) ((ParameterizedType) field.getGenericType())
					.getActualTypeArguments()[0];

			for (int i = 0; i < random().nextInt(101); i++) {
				Object value = getValue(listClassType, field, level - 1);
				if (value == null) {
					break;
				}
				values.add(value);
			}

			return values;
		} else if (level > 0) {
			return buildFor(type, level - 1);
		}

		return null;
	}

    /**
     * Creates an instance of informed class with random filled attributes <br>
     * Deep classes attributes will not be filled
     * @return
     *
     */
	public static <T> T buildFor(Class<T> clazz) {
		return buildFor(clazz, 0);
	}

}