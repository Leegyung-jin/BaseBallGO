package com.bbgo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStadium is a Querydsl query type for Stadium
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStadium extends EntityPathBase<Stadium> {

    private static final long serialVersionUID = -306017685L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStadium stadium = new QStadium("stadium");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> base = createNumber("base", Integer.class);

    public final StringPath content = createString("content");

    public final QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath row = createString("row");

    public final StringPath section = createString("section");

    public final NumberPath<Long> sno = createNumber("sno", Long.class);

    public final QTeam team;

    public QStadium(String variable) {
        this(Stadium.class, forVariable(variable), INITS);
    }

    public QStadium(Path<? extends Stadium> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStadium(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStadium(PathMetadata metadata, PathInits inits) {
        this(Stadium.class, metadata, inits);
    }

    public QStadium(Class<? extends Stadium> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
        this.team = inits.isInitialized("team") ? new QTeam(forProperty("team")) : null;
    }

}

