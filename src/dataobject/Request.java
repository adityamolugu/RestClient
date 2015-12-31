/**
 * 
 */
package dataobject;

import java.util.Map;

/**
 * @author Aditya.Molugu
 *
 */
public class Request {
	
	ArchiveReference archiveReference;
	Map<String,Object> index;
	Structure structure;
	/**
	 * @return the archiveReference
	 */
	public ArchiveReference getArchiveReference() {
		return archiveReference;
	}
	/**
	 * @param archiveReference the archiveReference to set
	 */
	public void setArchiveReference(ArchiveReference archiveReference) {
		this.archiveReference = archiveReference;
	}
	/**
	 * @return the index
	 *//*
	public Index getIndex() {
		return index;
	}
	*//**
	 * @param index the index to set
	 *//*
	public void setIndex(Index index) {
		this.index = index;
	}*/
	/**
	 * @return the structure
	 */
	public Structure getStructure() {
		return structure;
	}
	/**
	 * @return the index
	 */
	public Map<String, Object> getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(Map<String, Object> index) {
		this.index = index;
	}
	/**
	 * @param structure the structure to set
	 */
	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	
	
}
