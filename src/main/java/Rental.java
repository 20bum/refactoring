import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rental {
    private Movie _movie;
    private int _daysRented;

    public double getCharge() {
        double result = 0;

        // 비디오 종류별 대여료 계산
        switch (get_movie().get_priceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (get_daysRented() > 2)
                    result += (get_daysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += get_daysRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (get_daysRented() > 3)
                    result += (get_daysRented() - 3) * 1.5;
                break;
        }
        return result;
    }

    // 최신물을 이틀이상 대여하면 2포인트 지급하고 그 외엔 1포인트 지급하는 코드를
    // 빼내 getFrequentRenterPoints 메서드로 만들고 이 Rental 클래스로 옮겼다.
    public int getFrequentRenterPoints() {
        if ((get_movie().get_priceCode() == Movie.NEW_RELEASE) && get_daysRented() > 1)
            return 2;
        else
            return 1;
    }
}
