import java.util.List;
import java.util.stream.Collectors;


class Polyline {
    private List<Point> points;

    public Polyline(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        String pointsString = points.stream()
                .map(Point::toString)
                .collect(Collectors.joining(","));
        return "Линия [" + pointsString + "]";
    }
}
