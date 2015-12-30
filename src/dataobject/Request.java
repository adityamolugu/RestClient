/**
 * 
 */
package dataobject;

/**
 * @author Aditya.Molugu
 *
 */
public class Request {
	
	ArchiveReference archiveReference;
	Index index;
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
	 */
	public Index getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(Index index) {
		this.index = index;
	}
	/**
	 * @return the structure
	 */
	public Structure getStructure() {
		return structure;
	}
	/**
	 * @param structure the structure to set
	 */
	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	
	
}
