package tasks;

import common.Person;
import common.Task;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
А теперь о горьком
Всем придется читать код
А некоторым придется читать код, написанный мною
Сочувствую им
Спасите будущих жертв, и исправьте здесь все, что вам не по душе!
P.S. функции тут разные и рабочие (наверное), но вот их понятность и эффективность страдает (аж пришлось писать комменты)
P.P.S Здесь ваши правки желательно прокомментировать (можно на гитхабе в пулл реквесте)
 */
public class Task8 implements Task {

  static public List<String> getNames(List<Person> persons) {
    return persons.stream()
            .skip(1)
            .map(Person::getFirstName)
            .toList();
  }

  public Set<String> getDifferentNames(List<Person> persons) {
    return new HashSet<>(getNames(persons));
  }

  public String getFullName(Person person) {
    String fullName = "";
    if (person.getSecondName() != null) {
      fullName += person.getSecondName();
    }

    if (person.getFirstName() != null) {
      if (!fullName.equals("")) {
        fullName += " ";
      }
        fullName += person.getFirstName();
    }

    if (person.getMiddleName() != null) {
      if (!fullName.equals("")) {
        fullName += " ";
      }
      fullName += " " + person.getMiddleName();
    }
    return fullName;
  }

  public Map<Integer, String> getPersonNames(Collection<Person> persons) {
    return persons.stream().collect(Collectors.toMap(Person::getId, person -> getFullName(person)));
  }

  public boolean hasSamePersons(Collection<Person> persons1, Collection<Person> persons2) {
    return persons1.stream()
            .anyMatch(person -> persons2.contains(person));
  }

  public long countEven(Stream<Integer> numbers) {
    return numbers.filter(num -> (num % 2 == 0 && num != 0)).count();
  }

  @Override
  public boolean check() {
    System.out.println("notEZ Task");
    boolean codeSmellsGood = true;
    boolean reviewerDrunk = false;
    return codeSmellsGood || reviewerDrunk;
  }
}
