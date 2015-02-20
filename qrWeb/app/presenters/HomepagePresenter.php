<?php

namespace App\Presenters;

use Nette,
    Nette\Application\UI\Form;


/**
 * Homepage presenter.
 */
class HomepagePresenter extends BasePresenter
{

	public function renderDefault()
	{
		$this->template->anyVariable = 'any value';
	}

    protected function createComponentSearchForm()
    {
        $form = new Form;
        $form->addText('toSearch')
            ->setAttribute('id', 'tags')
            ->setAttribute('class','center')
        ;
        $form->addSubmit('find', 'Find')
            ->setAttribute('id','btnFind');

        $form->onSuccess[] = array($this, 'searchFormSucceeded');
        return $form;
    }

    //
    public function searchFormSucceeded($form, $values)
    {
        // ..
        $this->flashMessage('Finded 2 product');
        //$this->redirect('Homepage:', array("id_grammar", 123));
        $this->redirect("Search:list", array("search" => $values->toSearch));
    }

}
