package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHeroesStadium is a Querydsl query type for HeroesStadium
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHeroesStadium extends EntityPathBase<HeroesStadium> {

    private static final long serialVersionUID = 605773426L;

    public static final QHeroesStadium heroesStadium = new QHeroesStadium("heroesStadium");

    public final QSBaseEntity _super = new QSBaseEntity(this);

    public final StringPath base = createString("base");

    public final StringPath content = createString("content");

    public final NumberPath<Long> mno = createNumber("mno", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath row = createString("row");

    public final StringPath section = createString("section");

    public final NumberPath<Long> sno = createNumber("sno", Long.class);

    public final StringPath username = createString("username");

    public QHeroesStadium(String variable) {
        super(HeroesStadium.class, forVariable(variable));
    }

    public QHeroesStadium(Path<? extends HeroesStadium> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHeroesStadium(PathMetadata metadata) {
        super(HeroesStadium.class, metadata);
    }

}

