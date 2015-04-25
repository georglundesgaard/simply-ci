package no.lundesgaard.ci.model.event;

import no.lundesgaard.ci.Ci;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public abstract class Event {
	public final void process(Ci ci) {
		ci.tasks().stream().forEach(task -> task.trigger.onEvent(ci, task, this));
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
				.toString();
	}
}
