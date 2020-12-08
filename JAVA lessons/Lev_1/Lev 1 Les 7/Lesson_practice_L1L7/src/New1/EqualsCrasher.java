package New1;

import java.util.Objects;

public class EqualsCrasher {
    public int val;

    public EqualsCrasher(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsCrasher that = (EqualsCrasher) o;
        return val == that.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
