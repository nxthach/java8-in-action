package com.home;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingInt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.JapaneseDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.home.Dish.Type;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );

update
	
		
		
//		int sum = menu.stream().mapToInt(Dish::getCalories).sum();
//		
//		System.out.println(sum);
//		
//		OptionalInt maxCalories = menu
//				.stream()
//				.mapToInt(Dish::getCalories)
//				.max();
//		
//		System.out.println(maxCalories.getAsInt());
		
		
//		List<String> names = 
//			menu.stream()
//				.filter(d -> {
//					System.out.println("filtering " + d.getName());
//					return d.getCalories() > 300;
//				}).map(d -> {
//					System.out.println("mapping " + d.getName());
//					return d.getName();
//				}).limit(3)
//				.collect(Collectors.toList());
		
		
//		
//		List<Dish> dishes = menu.stream()
//				.filter(d -> d.getCalories() > 300)
//				.skip(2)
//				.collect(toList());
//		
//		dishes.forEach(System.out::println);
		
//		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
//		List<Integer> numbers2 = Arrays.asList(3, 4);
//		List<int[]> pairs = numbers1
//				.stream()
//				.flatMap(i -> numbers2.stream().map(j -> new int[] { i, j }))
//				.collect(toList());
		
		
		List<Integer> numbers = Arrays.asList(7, 2, 3, 4);
		
		
		//int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		
		//Optional<Integer> sum = numbers.stream().reduce((a, b) -> (a + b));
		
		//Optional<Integer> max = numbers.stream().reduce(Integer::max);
		
		
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), 
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950));
		
		
		String traderStr =
				transactions.stream()
				.map(transaction -> transaction.getTrader().getName())
				.distinct()
				.sorted()
				.collect(Collectors.joining(","));
		
		
		IntStream evenNumbers = 
			IntStream
				.rangeClosed(1, 100)
				.filter(n -> n % 2 == 0)
				;
		
		
		Stream<int[]> pythagoreanTriples =
				IntStream.rangeClosed(1, 10).boxed()
				.flatMap(
						a -> IntStream.rangeClosed(a, 100)
							.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
							.mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
				);
		
//		pythagoreanTriples.forEach( triple -> {
//			System.out.println(triple[0] + ", " + triple[1] + ", " + triple[2]);
//		} );
		
		
//		IntSupplier fib = new IntSupplier() {
//			private int previous = 0;
//			private int current = 1;
//
//			public int getAsInt() {
//				int oldPrevious = this.previous;
//				int nextValue = this.previous + this.current;
//				this.previous = this.current;
//				this.current = nextValue;
//				return oldPrevious;
//			}
//		};
//		IntStream.generate(fib).limit(10).forEach(System.out::println);
		
		
//		long howManyDishes = menu.stream().collect(Collectors.counting());
//		
//		howManyDishes = menu.stream().count();
//		

		
//		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
//		
//		Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));
		
		
		int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
		
		
		double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
		
		
		//String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
		
		int totalCalories2 = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
		
		
		
		Map<Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
		
		
		Map<Boolean, List<Dish>> partitionMenu = menu.stream().collect(partitioningBy(Dish::isVegetarian));
		
		int totalCalories1 = menu.stream().collect(summingInt(Dish::getCalories));
		
		
		
		Optional<Insurance> optInsurance = Optional.empty();
		
		optInsurance.filter(insurance -> "CambridgeInsurance".equals(insurance.getName()))
					.ifPresent(x -> System.out.println("ok"));		
		
		 
		
		//==============================================================================
		
		
		ZoneId romeZone = ZoneId.of("Europe/Rome");
		
		LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
		ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
		
		
		LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
		ZonedDateTime zdt2 = dateTime.atZone(romeZone);
		
		
		Instant instant = Instant.now();
		ZonedDateTime zdt3 = instant.atZone(romeZone);
		
		
		Instant instant1 = Instant.now();
		LocalDateTime timeFromInstant = LocalDateTime.ofInstant(instant, romeZone);
		
		
		ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
		
		LocalDateTime dateTime1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
		OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(dateTime1, newYorkOffset);
		
		
		LocalDate date1 = LocalDate.now();
		JapaneseDate japaneseDate = JapaneseDate.from(date1);
		
		Chronology japaneseChronology = Chronology.ofLocale(Locale.JAPAN);
		ChronoLocalDate now = japaneseChronology.dateNow();
		

		System.out.println(factorialStreams(5));
		
	}
	
	static long factorialStreams(long n) {
		return LongStream.rangeClosed(1, n).reduce(1, (long a, long b) -> a * b);
	}
	
	public static int readDuration(Properties props, String name) {
		return Optional.ofNullable(props.getProperty(name))
				.flatMap(OptionalUtility::stringToInt)
				.filter(i -> i > 0)
				.orElse(0);
	}
	
	
	public static double integrate(DoubleFunction<Double> f, double a, double b) {
		return (f.apply(a) + f.apply(b)) * (b - a) / 2.0;
	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();

		for (T t : list) {
			result.add(f.apply(t));
		}

		return result;
	}

	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T t : list) {
			c.accept(t);
		}
	}

	public static <T> void forEach2(List<T> list, AConsumer<T> c) {
		for (T t : list) {
			c.accept(t);
		}
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(""));

		return p.process(br);
	}

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if (p.test(e)) {
				result.add(e);
			}
		}

		return result;
	}

	public static <T> List<T> filter2(List<T> list, java.util.function.Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if (p.test(e)) {
				result.add(e);
			}
		}

		return result;
	}

	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
		for (Apple apple : inventory) {
			String output = formatter.accept(apple);
			System.out.println(output);
		}
	}

	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (predicate.test(apple)) {
				result.add(apple);
			}
		}

		return result;
	}
}

