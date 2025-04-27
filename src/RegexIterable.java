import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class RegexIterable implements Iterable<String> {
    private final Iterable<String> iterable;
    private final Pattern pattern;

    public RegexIterable(Iterable<String> iterable, String regex) {
        this.iterable = iterable;
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private final Iterator<String> it = iterable.iterator();
            private String nextMatch = null;
            private boolean hasNextComputed = false;

            private void computeNext() {
                while (it.hasNext()) {
                    String candidate = it.next();
                    if (pattern.matcher(candidate).find()) {
                        nextMatch = candidate;
                        hasNextComputed = true;
                        return;
                    }
                }
                nextMatch = null;
                hasNextComputed = true;
            }

            @Override
            public boolean hasNext() {
                if (!hasNextComputed) {
                    computeNext();
                }
                return nextMatch != null;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String result = nextMatch;
                hasNextComputed = false;
                nextMatch = null;
                return result;
            }
        };
    }
}

