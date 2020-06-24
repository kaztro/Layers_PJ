PGDMP         
                x            MODULO    12.3    12.3 M    m           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            n           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            o           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            p           1262    24624    MODULO    DATABASE     �   CREATE DATABASE "MODULO" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_El Salvador.1252' LC_CTYPE = 'Spanish_El Salvador.1252';
    DROP DATABASE "MODULO";
                postgres    false            �            1259    24713    centros_escolares    TABLE     �   CREATE TABLE public.centros_escolares (
    id_centro integer NOT NULL,
    nombre character varying(80) NOT NULL,
    descripcion text NOT NULL,
    estado boolean NOT NULL,
    id_municipio integer NOT NULL
);
 %   DROP TABLE public.centros_escolares;
       public         heap    postgres    false            �            1259    24711    centros_escolares_id_centro_seq    SEQUENCE     �   CREATE SEQUENCE public.centros_escolares_id_centro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.centros_escolares_id_centro_seq;
       public          postgres    false    213            q           0    0    centros_escolares_id_centro_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.centros_escolares_id_centro_seq OWNED BY public.centros_escolares.id_centro;
          public          postgres    false    212            �            1259    24627    departamento    TABLE     |   CREATE TABLE public.departamento (
    id_departamento integer NOT NULL,
    departamento character varying(30) NOT NULL
);
     DROP TABLE public.departamento;
       public         heap    postgres    false            �            1259    24625     departamento_id_departamento_seq    SEQUENCE     �   CREATE SEQUENCE public.departamento_id_departamento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.departamento_id_departamento_seq;
       public          postgres    false    203            r           0    0     departamento_id_departamento_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.departamento_id_departamento_seq OWNED BY public.departamento.id_departamento;
          public          postgres    false    202            �            1259    24731 
   estudiante    TABLE     �  CREATE TABLE public.estudiante (
    id_estudiante integer NOT NULL,
    nombres character varying(80) NOT NULL,
    apellidos character varying(80) NOT NULL,
    cminoridad text NOT NULL,
    fnac date NOT NULL,
    direccion text NOT NULL,
    telfijo character varying(8) NOT NULL,
    telmovil character varying(8) NOT NULL,
    nombremadre character varying(50) NOT NULL,
    nombrepadre character varying(50) NOT NULL,
    id_centro integer NOT NULL
);
    DROP TABLE public.estudiante;
       public         heap    postgres    false            �            1259    24729    estudiante_id_estudiante_seq    SEQUENCE     �   CREATE SEQUENCE public.estudiante_id_estudiante_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.estudiante_id_estudiante_seq;
       public          postgres    false    215            s           0    0    estudiante_id_estudiante_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.estudiante_id_estudiante_seq OWNED BY public.estudiante.id_estudiante;
          public          postgres    false    214            �            1259    24749    materia    TABLE     �   CREATE TABLE public.materia (
    id_materia integer NOT NULL,
    materia character varying(10) NOT NULL,
    descripcion text NOT NULL
);
    DROP TABLE public.materia;
       public         heap    postgres    false            �            1259    24760    materia_cursada    TABLE     �   CREATE TABLE public.materia_cursada (
    id_materiacursada integer NOT NULL,
    id_materia integer NOT NULL,
    id_estudiante integer NOT NULL,
    ano date NOT NULL,
    ciclo character varying(2) NOT NULL,
    nota numeric NOT NULL
);
 #   DROP TABLE public.materia_cursada;
       public         heap    postgres    false            �            1259    24758 %   materia_cursada_id_materiacursada_seq    SEQUENCE     �   CREATE SEQUENCE public.materia_cursada_id_materiacursada_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public.materia_cursada_id_materiacursada_seq;
       public          postgres    false    219            t           0    0 %   materia_cursada_id_materiacursada_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE public.materia_cursada_id_materiacursada_seq OWNED BY public.materia_cursada.id_materiacursada;
          public          postgres    false    218            �            1259    24747    materia_id_materia_seq    SEQUENCE     �   CREATE SEQUENCE public.materia_id_materia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.materia_id_materia_seq;
       public          postgres    false    217            u           0    0    materia_id_materia_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.materia_id_materia_seq OWNED BY public.materia.id_materia;
          public          postgres    false    216            �            1259    24637 	   municipio    TABLE     �   CREATE TABLE public.municipio (
    id_municipio integer NOT NULL,
    municipio character varying(30) NOT NULL,
    id_depart integer
);
    DROP TABLE public.municipio;
       public         heap    postgres    false            �            1259    24635    municipio_id_municipio_seq    SEQUENCE     �   CREATE SEQUENCE public.municipio_id_municipio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.municipio_id_municipio_seq;
       public          postgres    false    205            v           0    0    municipio_id_municipio_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.municipio_id_municipio_seq OWNED BY public.municipio.id_municipio;
          public          postgres    false    204            �            1259    24687    roles    TABLE     c   CREATE TABLE public.roles (
    id_rol integer NOT NULL,
    rol character varying(13) NOT NULL
);
    DROP TABLE public.roles;
       public         heap    postgres    false            �            1259    24685    roles_id_rol_seq    SEQUENCE     �   CREATE SEQUENCE public.roles_id_rol_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.roles_id_rol_seq;
       public          postgres    false    209            w           0    0    roles_id_rol_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.roles_id_rol_seq OWNED BY public.roles.id_rol;
          public          postgres    false    208            �            1259    24695    roles_usuario    TABLE     �   CREATE TABLE public.roles_usuario (
    id_rolesuser integer NOT NULL,
    id_usuario integer NOT NULL,
    id_rol integer NOT NULL
);
 !   DROP TABLE public.roles_usuario;
       public         heap    postgres    false            �            1259    24693    roles_usuario_id_rolesuser_seq    SEQUENCE     �   CREATE SEQUENCE public.roles_usuario_id_rolesuser_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.roles_usuario_id_rolesuser_seq;
       public          postgres    false    211            x           0    0    roles_usuario_id_rolesuser_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.roles_usuario_id_rolesuser_seq OWNED BY public.roles_usuario.id_rolesuser;
          public          postgres    false    210            �            1259    24652    usuario    TABLE     �  CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    enabled boolean NOT NULL,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    fnac date NOT NULL,
    direccion text NOT NULL,
    telfijo character varying(8) NOT NULL,
    telmovil character varying(8) NOT NULL,
    id_municipio integer NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    24650    usuario_id_usuario_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.usuario_id_usuario_seq;
       public          postgres    false    207            y           0    0    usuario_id_usuario_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;
          public          postgres    false    206            �
           2604    24716    centros_escolares id_centro    DEFAULT     �   ALTER TABLE ONLY public.centros_escolares ALTER COLUMN id_centro SET DEFAULT nextval('public.centros_escolares_id_centro_seq'::regclass);
 J   ALTER TABLE public.centros_escolares ALTER COLUMN id_centro DROP DEFAULT;
       public          postgres    false    213    212    213            �
           2604    24630    departamento id_departamento    DEFAULT     �   ALTER TABLE ONLY public.departamento ALTER COLUMN id_departamento SET DEFAULT nextval('public.departamento_id_departamento_seq'::regclass);
 K   ALTER TABLE public.departamento ALTER COLUMN id_departamento DROP DEFAULT;
       public          postgres    false    202    203    203            �
           2604    24734    estudiante id_estudiante    DEFAULT     �   ALTER TABLE ONLY public.estudiante ALTER COLUMN id_estudiante SET DEFAULT nextval('public.estudiante_id_estudiante_seq'::regclass);
 G   ALTER TABLE public.estudiante ALTER COLUMN id_estudiante DROP DEFAULT;
       public          postgres    false    215    214    215            �
           2604    24752    materia id_materia    DEFAULT     x   ALTER TABLE ONLY public.materia ALTER COLUMN id_materia SET DEFAULT nextval('public.materia_id_materia_seq'::regclass);
 A   ALTER TABLE public.materia ALTER COLUMN id_materia DROP DEFAULT;
       public          postgres    false    216    217    217            �
           2604    24763 !   materia_cursada id_materiacursada    DEFAULT     �   ALTER TABLE ONLY public.materia_cursada ALTER COLUMN id_materiacursada SET DEFAULT nextval('public.materia_cursada_id_materiacursada_seq'::regclass);
 P   ALTER TABLE public.materia_cursada ALTER COLUMN id_materiacursada DROP DEFAULT;
       public          postgres    false    218    219    219            �
           2604    24640    municipio id_municipio    DEFAULT     �   ALTER TABLE ONLY public.municipio ALTER COLUMN id_municipio SET DEFAULT nextval('public.municipio_id_municipio_seq'::regclass);
 E   ALTER TABLE public.municipio ALTER COLUMN id_municipio DROP DEFAULT;
       public          postgres    false    204    205    205            �
           2604    24690    roles id_rol    DEFAULT     l   ALTER TABLE ONLY public.roles ALTER COLUMN id_rol SET DEFAULT nextval('public.roles_id_rol_seq'::regclass);
 ;   ALTER TABLE public.roles ALTER COLUMN id_rol DROP DEFAULT;
       public          postgres    false    209    208    209            �
           2604    24698    roles_usuario id_rolesuser    DEFAULT     �   ALTER TABLE ONLY public.roles_usuario ALTER COLUMN id_rolesuser SET DEFAULT nextval('public.roles_usuario_id_rolesuser_seq'::regclass);
 I   ALTER TABLE public.roles_usuario ALTER COLUMN id_rolesuser DROP DEFAULT;
       public          postgres    false    211    210    211            �
           2604    24655    usuario id_usuario    DEFAULT     x   ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);
 A   ALTER TABLE public.usuario ALTER COLUMN id_usuario DROP DEFAULT;
       public          postgres    false    206    207    207            d          0    24713    centros_escolares 
   TABLE DATA           a   COPY public.centros_escolares (id_centro, nombre, descripcion, estado, id_municipio) FROM stdin;
    public          postgres    false    213   �_       Z          0    24627    departamento 
   TABLE DATA           E   COPY public.departamento (id_departamento, departamento) FROM stdin;
    public          postgres    false    203   �_       f          0    24731 
   estudiante 
   TABLE DATA           �   COPY public.estudiante (id_estudiante, nombres, apellidos, cminoridad, fnac, direccion, telfijo, telmovil, nombremadre, nombrepadre, id_centro) FROM stdin;
    public          postgres    false    215   `       h          0    24749    materia 
   TABLE DATA           C   COPY public.materia (id_materia, materia, descripcion) FROM stdin;
    public          postgres    false    217   )`       j          0    24760    materia_cursada 
   TABLE DATA           i   COPY public.materia_cursada (id_materiacursada, id_materia, id_estudiante, ano, ciclo, nota) FROM stdin;
    public          postgres    false    219   F`       \          0    24637 	   municipio 
   TABLE DATA           G   COPY public.municipio (id_municipio, municipio, id_depart) FROM stdin;
    public          postgres    false    205   c`       `          0    24687    roles 
   TABLE DATA           ,   COPY public.roles (id_rol, rol) FROM stdin;
    public          postgres    false    209   �`       b          0    24695    roles_usuario 
   TABLE DATA           I   COPY public.roles_usuario (id_rolesuser, id_usuario, id_rol) FROM stdin;
    public          postgres    false    211   �`       ^          0    24652    usuario 
   TABLE DATA           �   COPY public.usuario (id_usuario, username, password, enabled, nombre, apellido, fnac, direccion, telfijo, telmovil, id_municipio) FROM stdin;
    public          postgres    false    207   �`       z           0    0    centros_escolares_id_centro_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.centros_escolares_id_centro_seq', 1, false);
          public          postgres    false    212            {           0    0     departamento_id_departamento_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.departamento_id_departamento_seq', 1, false);
          public          postgres    false    202            |           0    0    estudiante_id_estudiante_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.estudiante_id_estudiante_seq', 1, false);
          public          postgres    false    214            }           0    0 %   materia_cursada_id_materiacursada_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public.materia_cursada_id_materiacursada_seq', 1, false);
          public          postgres    false    218            ~           0    0    materia_id_materia_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.materia_id_materia_seq', 1, false);
          public          postgres    false    216                       0    0    municipio_id_municipio_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.municipio_id_municipio_seq', 1, false);
          public          postgres    false    204            �           0    0    roles_id_rol_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.roles_id_rol_seq', 1, false);
          public          postgres    false    208            �           0    0    roles_usuario_id_rolesuser_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.roles_usuario_id_rolesuser_seq', 1, false);
          public          postgres    false    210            �           0    0    usuario_id_usuario_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 1, false);
          public          postgres    false    206            �
           2606    24721 (   centros_escolares centros_escolares_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY public.centros_escolares
    ADD CONSTRAINT centros_escolares_pkey PRIMARY KEY (id_centro);
 R   ALTER TABLE ONLY public.centros_escolares DROP CONSTRAINT centros_escolares_pkey;
       public            postgres    false    213            �
           2606    24634 *   departamento departamento_departamento_key 
   CONSTRAINT     m   ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT departamento_departamento_key UNIQUE (departamento);
 T   ALTER TABLE ONLY public.departamento DROP CONSTRAINT departamento_departamento_key;
       public            postgres    false    203            �
           2606    24632    departamento departamento_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (id_departamento);
 H   ALTER TABLE ONLY public.departamento DROP CONSTRAINT departamento_pkey;
       public            postgres    false    203            �
           2606    24739    estudiante estudiante_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT estudiante_pkey PRIMARY KEY (id_estudiante);
 D   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT estudiante_pkey;
       public            postgres    false    215            �
           2606    24768 $   materia_cursada materia_cursada_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public.materia_cursada
    ADD CONSTRAINT materia_cursada_pkey PRIMARY KEY (id_materiacursada);
 N   ALTER TABLE ONLY public.materia_cursada DROP CONSTRAINT materia_cursada_pkey;
       public            postgres    false    219            �
           2606    24757    materia materia_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.materia
    ADD CONSTRAINT materia_pkey PRIMARY KEY (id_materia);
 >   ALTER TABLE ONLY public.materia DROP CONSTRAINT materia_pkey;
       public            postgres    false    217            �
           2606    24644 !   municipio municipio_municipio_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.municipio
    ADD CONSTRAINT municipio_municipio_key UNIQUE (municipio);
 K   ALTER TABLE ONLY public.municipio DROP CONSTRAINT municipio_municipio_key;
       public            postgres    false    205            �
           2606    24642    municipio municipio_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.municipio
    ADD CONSTRAINT municipio_pkey PRIMARY KEY (id_municipio);
 B   ALTER TABLE ONLY public.municipio DROP CONSTRAINT municipio_pkey;
       public            postgres    false    205            �
           2606    24692    roles roles_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id_rol);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    209            �
           2606    24700     roles_usuario roles_usuario_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.roles_usuario
    ADD CONSTRAINT roles_usuario_pkey PRIMARY KEY (id_rolesuser);
 J   ALTER TABLE ONLY public.roles_usuario DROP CONSTRAINT roles_usuario_pkey;
       public            postgres    false    211            �
           2606    24660    usuario usuario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    207            �
           2606    24722 5   centros_escolares centros_escolares_id_municipio_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.centros_escolares
    ADD CONSTRAINT centros_escolares_id_municipio_fkey FOREIGN KEY (id_municipio) REFERENCES public.municipio(id_municipio);
 _   ALTER TABLE ONLY public.centros_escolares DROP CONSTRAINT centros_escolares_id_municipio_fkey;
       public          postgres    false    205    2756    213            �
           2606    24740 $   estudiante estudiante_id_centro_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT estudiante_id_centro_fkey FOREIGN KEY (id_centro) REFERENCES public.centros_escolares(id_centro);
 N   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT estudiante_id_centro_fkey;
       public          postgres    false    215    2764    213            �
           2606    24774 2   materia_cursada materia_cursada_id_estudiante_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.materia_cursada
    ADD CONSTRAINT materia_cursada_id_estudiante_fkey FOREIGN KEY (id_estudiante) REFERENCES public.estudiante(id_estudiante);
 \   ALTER TABLE ONLY public.materia_cursada DROP CONSTRAINT materia_cursada_id_estudiante_fkey;
       public          postgres    false    215    219    2766            �
           2606    24769 /   materia_cursada materia_cursada_id_materia_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.materia_cursada
    ADD CONSTRAINT materia_cursada_id_materia_fkey FOREIGN KEY (id_materia) REFERENCES public.materia(id_materia);
 Y   ALTER TABLE ONLY public.materia_cursada DROP CONSTRAINT materia_cursada_id_materia_fkey;
       public          postgres    false    2768    217    219            �
           2606    24645 "   municipio municipio_id_depart_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.municipio
    ADD CONSTRAINT municipio_id_depart_fkey FOREIGN KEY (id_depart) REFERENCES public.departamento(id_departamento);
 L   ALTER TABLE ONLY public.municipio DROP CONSTRAINT municipio_id_depart_fkey;
       public          postgres    false    205    203    2752            �
           2606    24706 '   roles_usuario roles_usuario_id_rol_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.roles_usuario
    ADD CONSTRAINT roles_usuario_id_rol_fkey FOREIGN KEY (id_rol) REFERENCES public.roles(id_rol);
 Q   ALTER TABLE ONLY public.roles_usuario DROP CONSTRAINT roles_usuario_id_rol_fkey;
       public          postgres    false    211    209    2760            �
           2606    24701 +   roles_usuario roles_usuario_id_usuario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.roles_usuario
    ADD CONSTRAINT roles_usuario_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);
 U   ALTER TABLE ONLY public.roles_usuario DROP CONSTRAINT roles_usuario_id_usuario_fkey;
       public          postgres    false    207    2758    211            �
           2606    24661 !   usuario usuario_id_municipio_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_id_municipio_fkey FOREIGN KEY (id_municipio) REFERENCES public.municipio(id_municipio);
 K   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_id_municipio_fkey;
       public          postgres    false    2756    207    205            d      x������ � �      Z      x������ � �      f      x������ � �      h      x������ � �      j      x������ � �      \      x������ � �      `      x������ � �      b      x������ � �      ^      x������ � �     