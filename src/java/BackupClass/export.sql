DECLARE
  schemaname    VARCHAR2(200) := ?;
  directoryname VARCHAR2(200) := ?;
  dumpfilename  VARCHAR2(200) := ?;
 
  directoryvariable VARCHAR(100) 
                    := 'EXPORT_DIR_' || schemaname;
 
  handle            NUMBER;
  status            VARCHAR2(20);
BEGIN
EXECUTE IMMEDIATE 'CREATE OR REPLACE DIRECTORY '
                    || directoryvariable || ' AS '''
                    || directoryname || '''';
 
  handle := DBMS_DATAPUMP.OPEN(
    operation => 'EXPORT',
    job_mode  => 'SCHEMA',
    job_name  => 'datapump export schema '
                 || schemaname);
 
  DBMS_DATAPUMP.ADD_FILE(
    handle    => handle,
    filename  => dumpfilename,
    directory => directoryvariable,
    reusefile => 1);
 
  DBMS_DATAPUMP.ADD_FILE(
    handle    => handle,
    filename  => dumpfilename || '.export.log',
    directory => directoryvariable,
    filetype  => DBMS_DATAPUMP.KU$_FILE_TYPE_LOG_FILE,
    reusefile => 1);
 
  DBMS_DATAPUMP.METADATA_FILTER(
    handle => handle,
    name   => 'SCHEMA_EXPR',
    value  => 'IN (''' || schemaname || ''')');
 
  DBMS_DATAPUMP.START_JOB(handle);
  DBMS_DATAPUMP.WAIT_FOR_JOB(handle, status);
 
  EXECUTE IMMEDIATE 'DROP DIRECTORY '
                    || directoryvariable;
END;