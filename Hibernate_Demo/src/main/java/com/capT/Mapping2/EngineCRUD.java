package com.capT.Mapping2;

public interface EngineCRUD {
	void saveEngine(Engine e);
	void updateEngineCC(int id, int cc);
	void deleteEngine(int id);
	void fetchEngineById(int id);
	void fetchEngineByCC(int cc);
	void findAllEngines();
}
