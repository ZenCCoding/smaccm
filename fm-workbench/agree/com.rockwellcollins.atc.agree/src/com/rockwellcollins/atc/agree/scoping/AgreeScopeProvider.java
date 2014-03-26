/*
 * generated by Xtext
 */
package com.rockwellcollins.atc.agree.scoping;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.Element;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.impl.FeatureGroupImpl;
import org.osate.annexsupport.AnnexUtil;

import com.rockwellcollins.atc.agree.agree.AgreeContract;
import com.rockwellcollins.atc.agree.agree.AgreeContractLibrary;
import com.rockwellcollins.atc.agree.agree.AgreeContractSubclause;
import com.rockwellcollins.atc.agree.agree.AgreeLibrary;
import com.rockwellcollins.atc.agree.agree.AgreePackage;
import com.rockwellcollins.atc.agree.agree.CalenStatement;
import com.rockwellcollins.atc.agree.agree.EqStatement;
import com.rockwellcollins.atc.agree.agree.FnDefExpr;
import com.rockwellcollins.atc.agree.agree.NestedDotID;
import com.rockwellcollins.atc.agree.agree.NodeDefExpr;
import com.rockwellcollins.atc.agree.agree.SpecStatement;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping on how and when
 * to use it
 * 
 */
public class AgreeScopeProvider extends
        org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider {

    IScope scope_NamedElement(FnDefExpr ctx, EReference ref) {
        return Scopes.scopeFor(ctx.getArgs(), getScope(ctx.eContainer(), ref));
    }
    
    IScope scope_NamedElement(EqStatement ctx, EReference ref) {
        return Scopes.scopeFor(ctx.getLhs(), getScope(ctx.eContainer(), ref));
    }

    IScope scope_NamedElement(NodeDefExpr ctx, EReference ref) {
        Set<Element> components = new HashSet<>();
        components.addAll(ctx.getArgs());
        components.addAll(ctx.getRets());
        components.addAll(ctx.getNodeBody().getLocs());
        return Scopes.scopeFor(components, getScope(ctx.eContainer(), ref));
    }
    
    IScope scope_NamedElement(AgreeContract ctx, EReference ref) {
        EObject container = ctx.eContainer().eContainer();

        if(container instanceof ComponentImplementation){
            ComponentType compType = ((ComponentImplementation) container).getType();
            for (AnnexSubclause subclause : AnnexUtil.getAllAnnexSubclauses(compType, AgreePackage.eINSTANCE.getAgreeSubclause())) {
                if (subclause instanceof AgreeContractSubclause) {
                    IScope scopeOfType = getScope(((AgreeContractSubclause) subclause).getContract(),
                            ref);
                    return Scopes.scopeFor(getAllElementsFromSpecs(ctx.getSpecs()), scopeOfType);
                }
            }
        }
        return Scopes.scopeFor(getAllElementsFromSpecs(ctx.getSpecs()), IScope.NULLSCOPE);
                
        /*
        EObject container = ctx.eContainer().eContainer();
        if (container instanceof ComponentType) {
            return null;
        }
        if (!(container instanceof ComponentImplementation)) {
            return IScope.NULLSCOPE;
        }

        ComponentType compType = ((ComponentImplementation) container).getType();
        for (AnnexSubclause subclause : compType.getAllAnnexSubclauses()) {
            if (subclause instanceof AgreeContractSubclause) {
                IScope scopeOfType = getScope(((AgreeContractSubclause) subclause).getContract(),
                        ref);
                return Scopes.scopeFor(getAllElementsFromSpecs(ctx.getSpecs()), scopeOfType);
            }
        }
        return IScope.NULLSCOPE;
        */
    }
    

    private Set<Element> getAllElementsFromSpecs(EList<SpecStatement> specs) {
        Set<Element> result = new HashSet<>();
        for (SpecStatement spec : specs) {
            if (spec instanceof EqStatement) {
                EqStatement eq = (EqStatement) spec;
                result.addAll(eq.getLhs());
            } else {
                result.add(spec);
            }
        }
        return result;
    }

    IScope scope_NamedElement(CalenStatement ctx, EReference ref) {
        
    	EObject container = ctx.getContainingClassifier();
    	while(!(container instanceof ComponentClassifier)){
    		container = container.eContainer();
    	}
    	
    	if(container instanceof ComponentImplementation){
    		return Scopes.scopeFor(((ComponentImplementation)container).getAllSubcomponents());
    	}
    	return IScope.NULLSCOPE;
    }
    
    IScope scope_NamedElement(NestedDotID ctx, EReference ref) {
        Set<Element> components = getCorrespondingAadlElement(ctx);
        return Scopes.scopeFor(components, getScope(ctx.eContainer(), ref));
    }
    
    /*
    IScope scope_NamedElement(ClockID ctx, EReference ref){
        EObject container = ctx.eContainer();
        while(!(container instanceof ComponentClassifier)){
            container = container.eContainer();
        }
        
        if(container instanceof ComponentImplementation){
            return Scopes.scopeFor(((ComponentImplementation)container).getAllSubcomponents(), getScope(ctx.eContainer(), ref));
        }
        
        return IScope.NULLSCOPE;
    }
    
    IScope scope_NamedElement(QueueRemoveID ctx, EReference ref){
        EObject container = ctx.eContainer();
        while(!(container instanceof ComponentClassifier)){
            container = container.eContainer();
        }
        
        return Scopes.scopeFor(((ComponentClassifier)container).getAllFeatures(), getScope(ctx.eContainer(), ref));
        
        
    }
    
    IScope scope_NamedElement(QueueInsertID ctx, EReference ref){
        EObject container = ctx.eContainer();
        while(!(container instanceof ComponentClassifier)){
            container = container.eContainer();
        }
        
        return Scopes.scopeFor(((ComponentClassifier)container).getAllFeatures(), getScope(ctx.eContainer(), ref));
        
        
    }
    
    IScope scope_NamedElement(QueueCountID ctx, EReference ref){
        EObject container = ctx.eContainer();
        while(!(container instanceof ComponentClassifier)){
            container = container.eContainer();
        }
        
        return Scopes.scopeFor(((ComponentClassifier)container).getAllFeatures(), getScope(ctx.eContainer(), ref));
        
        
    }
    */
    
    private Set<Element> getCorrespondingAadlElement(NestedDotID id) {
        EObject container = id.eContainer();

        if (container instanceof NestedDotID) {
            NestedDotID parent = (NestedDotID) container;
            EList<EObject> refs = parent.eCrossReferences();

            if (refs.size() != 1) {
                return new HashSet<>(); // this will throw a parsing error
            }
            container = refs.get(0);

            if(container instanceof ThreadSubcomponent){
                container = ((ThreadSubcomponent)container).getComponentType();
            }else if (container instanceof Subcomponent) {
                container = ((Subcomponent) container).getComponentImplementation();
                if(container == null){ //no implementation is provided
                    container = refs.get(0);
                    container = ((Subcomponent) container).getClassifier();
                }
            } else if (container instanceof DataPort) {
                container = ((DataPort) container).getDataFeatureClassifier();
            }else if (container instanceof EventDataPort){
            	container = ((EventDataPort) container).getDataFeatureClassifier();
            } else if (container instanceof AadlPackage) {
                for (AnnexLibrary annex : ((AadlPackage) container).getPublicSection()
                        .getOwnedAnnexLibraries()) {
                    if (annex instanceof AgreeLibrary) {
                        container = ((AgreeContractLibrary) annex).getContract();
                    }
                }
            }else if (container instanceof FeatureGroupImpl){
              container = ((FeatureGroupImpl)container).getAllFeatureGroupType();
            } else {
                return new HashSet<>(); // this will throw a parsing error
            }
        } else {
            // travel out of the annex and get the component
            // classifier that the annex is contained in.
            // If the annex is in a library (not a component),
            // then stop once you hit the contract library
            while (!(container instanceof ComponentClassifier)
                    && !(container instanceof AgreeContractLibrary)) {
                container = container.eContainer();
            }
        }

        if (container == null) {
            return new HashSet<>(); // this will throw a parsing error
        }

        Set<Element> result = new HashSet<>();

        if (container instanceof Classifier) {
            Classifier component = (Classifier) container;
            for (Element el : component.getOwnedElements()) {
                result.add(el);
            }
            for (Element el : component.getAllFeatures()) {
                result.add(el);
            }
        } else {

            if (container instanceof AgreeContractLibrary) {
                container = ((AgreeContractLibrary) container).getContract();
            }

            assert (container instanceof AgreeContract);
            result = getAllElementsFromSpecs(((AgreeContract) container).getSpecs());

        }

        return result;
    }

}
