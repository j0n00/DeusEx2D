package engine.components;

import com.artemis.Component;

public class SpatialForm extends Component {

	private String spatialFormFile;

	public SpatialForm(String spatialFormFile) {
		this.spatialFormFile = spatialFormFile;
	}

	public String getSpatialFormFile() {
		return spatialFormFile;
	}

}
