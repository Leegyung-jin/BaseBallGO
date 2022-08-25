package com.bbgo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStadium is a Querydsl query type for Stadium
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStadium extends EntityPathBase<Stadium> {

    private static final long serialVersionUID = -306017685L;

    public static final QStadium stadium = new QStadium("stadium");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath base = createString("base");

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath row = createString("row");

    public final StringPath section = createString("section");

    public final NumberPath<Long> sno = createNumber("sno", Long.class);

    public QStadium(String variable) {
        super(Stadium.class, forVariable(variable));
    }

    public QStadium(Path<? extends Stadium> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStadium(PathMetadata metadata) {
        super(Stadium.class, metadata);
    }

}

