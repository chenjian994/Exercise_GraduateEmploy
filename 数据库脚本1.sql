/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     2013/8/12 17:16:15                           */
/*==============================================================*/


if exists (select 1
            from  sysindexes
           where  id    = object_id('graduate_job')
            and   name  = '被申请_FK'
            and   indid > 0
            and   indid < 255)
   drop index graduate_job.被申请_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('graduate_job')
            and   name  = '申请_FK'
            and   indid > 0
            and   indid < 255)
   drop index graduate_job.申请_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('graduate_job')
            and   type = 'U')
   drop table graduate_job
go

if exists (select 1
            from  sysobjects
           where  id = object_id('t_admin')
            and   type = 'U')
   drop table t_admin
go

if exists (select 1
            from  sysobjects
           where  id = object_id('t_enterprise')
            and   type = 'U')
   drop table t_enterprise
go

if exists (select 1
            from  sysobjects
           where  id = object_id('t_graduate')
            and   type = 'U')
   drop table t_graduate
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('t_job')
            and   name  = 'enterprise_job_FK'
            and   indid > 0
            and   indid < 255)
   drop index t_job.enterprise_job_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('t_job')
            and   type = 'U')
   drop table t_job
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('t_profile')
            and   name  = 'graduate_profile_FK'
            and   indid > 0
            and   indid < 255)
   drop index t_profile.graduate_profile_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('t_profile')
            and   type = 'U')
   drop table t_profile
go

/*==============================================================*/
/* Table: graduate_job                                          */
/*==============================================================*/
create table graduate_job (
   id                   int                  not null,
   no                   int                  not null,
   constraint PK_GRADUATE_JOB primary key (id, no)
)
go

/*==============================================================*/
/* Index: 申请_FK                                                 */
/*==============================================================*/
create index 申请_FK on graduate_job (
id ASC
)
go

/*==============================================================*/
/* Index: 被申请_FK                                                */
/*==============================================================*/
create index 被申请_FK on graduate_job (
no ASC
)
go

/*==============================================================*/
/* Table: t_admin                                               */
/*==============================================================*/
create table t_admin (
   id                   int                  identity,
   username             varchar(20)          null,
   password             varchar(20)          null,
   constraint PK_T_ADMIN primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: t_enterprise                                          */
/*==============================================================*/
create table t_enterprise (
   id                   int                  identity,
   username             varchar(20)          null,
   password             varchar(20)          null,
   name                 varchar(50)          null,
   summary              varchar(255)         null,
   establishDate        datetime             null,
   type                 varchar(50)          null,
   address              varchar(50)          null,
   employeeAmount       int                  null,
   contact              varchar(50)          null,
   phone                varchar(20)          null,
   verified             bit                  null,
   website              varchar(50)          null,
   email                varchar(50)          null,
   constraint PK_T_ENTERPRISE primary key nonclustered (id)
)
go

/*==============================================================*/
/* Table: t_graduate                                            */
/*==============================================================*/
create table t_graduate (
   no                   int                  identity,
   name                 varchar(20)          null,
   username             varchar(20)          null,
   password             varchar(20)          null,
   sex                  varchar(2)           null,
   profile              varchar(20)          null,
   background           varchar(20)          null,
   school               varchar(50)          null,
   college              varchar(20)          null,
   major                varchar(20)          null,
   phone                varchar(20)          null,
   email                varchar(30)          null,
   address              varchar(50)          null,
   selfEval             varchar(255)         null,
   addition             varchar(255)         null,
   verified             bit                  null,
   constraint PK_T_GRADUATE primary key nonclustered (no)
)
go

/*==============================================================*/
/* Table: t_job                                                 */
/*==============================================================*/
create table t_job (
   id                   int                  identity,
   t_e_id               int                  null,
   name                 varchar(20)          null,
   age                  varchar(50)          null,
   sex                  varchar(2)           null,
   background           varchar(50)          null,
   workExper            varchar(50)          null,
   employMode           varchar(20)          null,
   salary               varchar(20)          null,
   workAddress          varchar(20)          null,
   publidhDate          datetime             null,
   endDate              datetime             null,
   require              varchar(255)         null,
   constraint PK_T_JOB primary key nonclustered (id)
)
go

/*==============================================================*/
/* Index: enterprise_job_FK                                     */
/*==============================================================*/
create index enterprise_job_FK on t_job (
t_e_id ASC
)
go

/*==============================================================*/
/* Table: t_profile                                             */
/*==============================================================*/
create table t_profile (
   explain              text                 not null,
   type                 varchar(100)         not null,
   id                   int                  identity,
   no                   int                  not null,
   constraint PK_T_PROFILE primary key nonclustered (id)
)
go

/*==============================================================*/
/* Index: graduate_profile_FK                                   */
/*==============================================================*/
create index graduate_profile_FK on t_profile (
no ASC
)
go

