package ironpeace.jobflow;

import ironpeace.modelgen.dmdl.csv.AbstractOriginalDataCsvInputDescription;

public class OriginalDataFromCsv extends AbstractOriginalDataCsvInputDescription {

	@Override
	public String getBasePath() {
		return "ironpeace/grouping/input/";
	}

	@Override
	public String getResourcePattern() {
		return "originaldata.csv";
	}
}
