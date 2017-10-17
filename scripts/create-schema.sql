CREATE TABLE MODEL_CONFIG (
  Model_Id INTEGER primary key, 
  Model_Name VARCHAR(100), 
  Model_File_Name VARCHAR(100), 
  Label_File_Name VARCHAR(100));
  
create sequence model_config_sequence start with 1;

CREATE TABLE IMAGE (
  Image_Id INTEGER primary key, 
  Image_Guid VARCHAR(100), 
  Image_File_Name VARCHAR(1000), 
  Image_Description VARCHAR(100));
  
create sequence image_sequence start with 1;  

CREATE TABLE IMAGE_CLASSIFICATION (
  Classification_Id INTEGER primary key, 
  Image_Id INTEGER, 
  Model_Id Integer, 
  CLASSIFICATION_LABEL VARCHAR(1000),
  CLASSIFICATION_SCORE FLOAT(10));
  
create sequence image_classification_sequence start with 1;