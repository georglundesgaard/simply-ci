package no.lundesgaard.ci.model.job;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public final class JobId implements Serializable {
	public final String id;

	public static JobId jobId(String id) {
		return new JobId(id);
	}

	public static JobId jobId(Job job) {
		return jobId(job.id);
	}

	private JobId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		JobId jobId = (JobId) o;

		return new EqualsBuilder()
				.append(id, jobId.id)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
				.append("id", id)
				.toString();
	}
}