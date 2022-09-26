package uni.obuda.testaut.java.bookstore.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BaseObject {

    @Override
    public boolean equals(Object o) {
        if (this == o)
        {
            return true;
        } else {
            return o != null && this.getClass() == o.getClass() ? EqualsBuilder.reflectionEquals(this, this.getClass().cast(o), new String[0]) : false;
        }
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[0]);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
